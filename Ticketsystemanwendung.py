from tkinter import *

root = Tk()
root.title("Ticketsystem")

def onClickMyButton():
    myLabel2.config(text=myTextfield.get())

myLogo = Label(root, text="BFW Logo")
myLabel = Label(root, text="BFW Ticketsystem")
myButton = Button(root, text="Click me!", command=onClickMyButton)
myTextfield = Entry(root, width= 10)
myLabel2 = Label(root, text="", state=DISABLED)

myLogo.grid(row=0, column=0)
myLabel.grid(row=0, column=1)
myButton.grid(row=1, column=3)
myTextfield.grid(row=1, column=0)
myLabel2.grid(row=2, column=1)



root.mainloop()