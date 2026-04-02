# DonInf2 Starting Code
This some boiler plate code for the "Conception Orientée Objet" course project. Use this code as starting point for your project.

## Setup
### 1. Repository On Github
First you need to get a copy of this repository, the best approach is to fork this repository. a fork is a github specific functionality, it creates your own copy of a repository. You need a github account in order to fork a repository.
**Only one team member should perform that**
- Login to your github account
- At the top right of the github window use the **Fork** button > **Create new fork**
- Name it <M54-X-groupname> according to your class and group
- Share the repository with your group members
    - Go to Settings
    - Collaborators and team
    - (Manage access) > Add people

### 2. Setup your local workspace

Now, each team member can configure their local workspace.

#### 2.1 OPTIONAL install git command line
If you want to learn command line tools as well, you can install the git command line on your machine.
[instructions here](https://github.com/git-guides/install-git)

#### 2.2 Repository local setup

In the directory you chose above you should now have a new directory named after you repository name.

##### Using the command line
- In your github repository click the **Code** button and select SSH and copy the URL
- Open a console in the directory you want your repository
- clone the repository with the command
```
git clone <copied-url>
```

##### Using the Github Desktop Application
Alternatively, you can use the Github Desktop application
- Download the app and install it
- Run it and log in with your github account
- At the top left click **Add** and choose **Clone Repository**
- Select your newly created repository and choose a directory to clone it on your machine.

## Running the project

### IDE
Use your favorite IDE to run the project, Visual Studio Code is advised. Open the repository directory in your IDE and run the `main` which is found in `src/main/Main.java`.

### command line
Alternatively, you can run the project with the `buildAndRun.sh` script. Open a terminal or console in the repository directory and run the following command

```
./buildAndRun.sh
```

To run the script, you need java installed on your computer.
If running a Windows computer you also need bash shell installed (for example Git For Windows https://gitforwindows.org/).

## Folder contents

### utils
Utils contains a few helper functions to help you during your project, mainly you will find 
- Array2DPrinter : functions to draw your map in the console
- StringStyling.java => functions to color and style strings in the console (80s retro style :))

### examples
- String manipulation examples are found in the `src/exemples` folder and called in the main function. Feel free to remove these calls.
- Basic user input example (as a reminder)
- Usage of the string styling helpers

### main
Contains the Main class => the entry point to your program. And an empty `Game` class, this is where things start !

## About this README
Feel free to edit this README as well, it's yours :)
The format of this file is [markdown](https://markdownlivepreview.com/)

