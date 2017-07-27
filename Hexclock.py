import tkinter as tk, time
x = 0
y = 0
ax = 0
ay = 0
def colorchange(string):
	main.config(bg = string)
	display.config(text = string, bg = string)

def every_second():
	now = '#' + time.strftime('%H%M%S', time.localtime())
	colorchange(now)
	main.after(1000, every_second)


main = tk.Tk()
main.overrideredirect(1)
main.wm_attributes('-topmost', 1)
main.geometry('400x100')

def Clk(event):
	global ax, ay
	ax = event.x
	ay = event.y

def frameDrag(event, self = main):
	global x, y, ax, ay
	x = main.winfo_pointerx() - ax
	y = main.winfo_pointery() - ay
	self.geometry("400x100+%d+%d"%(x, y))

thistime = '#' + time.strftime('%H%M%S', time.localtime())
main.config(bg = thistime)
display = tk.Label(main, text = thistime, font = ('consolas', 70, 'bold'), bg = thistime, fg = 'white')
display.bind('<Double-Button-1>', exit)
main.bind('<B1-Motion>', frameDrag)
main.bind('<Button-1>', Clk)

display.pack()

if __name__ == '__main__':
	main.after(1000, every_second)
	main.mainloop()
