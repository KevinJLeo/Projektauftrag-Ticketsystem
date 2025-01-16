from tkinter import *

root = Tk()
root.title("Taschenrechner")

ergebnisFeld = Entry(root, width=35, borderwidth=5)
ergebnisFeld.grid(row=0, columnspan=3, padx=10, pady=10)

def onButtonClick():
    pass

button1 = Button(root, text="1", padx=40, pady=20, command=onButtonClick)
button2 = Button(root, text="2", padx=40, pady=20, command=onButtonClick)
button3 = Button(root, text="3", padx=40, pady=20, command=onButtonClick)
button4 = Button(root, text="4", padx=40, pady=20, command=onButtonClick)
button5 = Button(root, text="5", padx=40, pady=20, command=onButtonClick)
button6 = Button(root, text="6", padx=40, pady=20, command=onButtonClick)
button7 = Button(root, text="7", padx=40, pady=20, command=onButtonClick)
button8 = Button(root, text="8", padx=40, pady=20, command=onButtonClick)
button9 = Button(root, text="9", padx=40, pady=20, command=onButtonClick)
button0 = Button(root, text="0", padx=40, pady=20, command=onButtonClick)



button1.grid(row=3, column=0)
button2.grid(row=3, column=1)
button3.grid(row=3, column=2)
button4.grid(row=2, column=0)
button5.grid(row=2, column=1)
button6.grid(row=2, column=2)
button7.grid(row=1, column=0)
button8.grid(row=1, column=1)
button9.grid(row=1, column=2)
button0.grid(row=4, column=0)

root.mainloop()