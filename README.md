# Conception Orientée Objet Starting Code
This is the starting code for the "Conception Orientée Objet" course project.

## The _devoirs_ folder
A few assignements will require you to hand in documents, you will place them in the `devoirs` folder. Explanations to add your files are found [here](devoirs/README.md).

## Setup
Each team member will need to get a local copy of the code on his computer. Here are the instructions to do your setup

### install the git command line
If not yet configured on your machine, install the git command line on your machine.
[instructions here](https://github.com/git-guides/install-git)

### Repository local setup
Pick some location folder on your machine where you will checkout your code. For example you can create the `~/Git/ConcepObjProject` folder on your machine.

#### Using the command line
Assuming you already have installed and configured git on your machine

- In your github repository click the **Code** button and select SSH and copy the URL
- Open a console in the directory you created above
- clone the repository with the command
```
git clone <copied-url>
```

#### Using the Github Desktop Application
Alternatively, you can use the Github Desktop application
- Download the app and install it
- Run it and log in with your github account
- At the top left click **Add** and choose **Clone Repository**
- Select your team's repository and pick the directory you created above to clone it on your machine.

## Running the project

### IDE
Use your favorite IDE to run the project, Visual Studio Code is advised and will be used during this course. Open the repository directory in your IDE and run the `main` method which is found in `src/main/Main.java`.

### command line
Alternatively, you can run the project with the `buildAndRun.sh` script. Open a terminal or console in the repository directory and run the following command

```
./buildAndRun.sh
```

To run the script, you need java installed on your computer.
If running a Windows computer you also need bash shell installed (for example Git For Windows https://gitforwindows.org/).

## src folder contents

Here is an overview of the code you start with. Feel free to add folders to organize your code.

### scr/utils
Utils contains a few helper functions to help you during your project, mainly you will find
- Array2DPrinter : functions to draw your map in the console
- StringStyling => functions to color and style strings in the console (80s retro style :))

### src/examples
- String processing examples are found in the `src/exemples` folder and called in the main function. Feel free to remove these calls.
- Basic user input example using a scanner (as a reminder)
- Usage of the string styling helpers

### scr/main
Contains the Main class => the entry point to your program. And an empty `Game` class, this is where things start !

## About this README
Feel free to edit this README as well, it's yours :)
The format of this file is [markdown](https://markdownlivepreview.com/)

