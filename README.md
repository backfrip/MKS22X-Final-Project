# MKS22X Final Project
**_Team `<teamname>` - WC & ES_**

### Abstract
A two-dimensional, isometric [dimetric], role-playing game.

### Compile & Run Intructions
##### Eclipse
  1. Run Eclipse
  2. In the File menu, select `Import... > General > Existing Projects into Workspace`
  3. Set root directory to MKS22-Final-Project repository
  4. Make sure "Copy projects into workspace" is unchecked
  5. Run project (`Run > Run`)

##### Command Line
  1. Navigate to MKS22X-Final-Project directory
  2. Compile with: `javac -d bin -cp "lib/*" -sourcepath src src/main/Main.java`
  3. Using Java 7 or later, run with: `java -cp "lib/*;bin" main.Main`  
  Using Java 6 or earlier, run with: `java -cp "lib/*:bin" main.Main`


## Changelog

### [Version 0.0.5](https://github.com/backfrip/MKS22X-Final-Project) (2015-05-30)

##### New Features
  - Added transparency to resource/img/tile.png
  - Added more configuration settings to launcher class (Main.java), plan to make them adjustable in-game and recall on startup
  - Allowed for fullscreening (press space for now), FillViewport auto-resizes and crops
  - Tile rendering test

### [Version 0.0.4](https://github.com/backfrip/MKS22X-Final-Project/commit/c94bc713634837ce4ccfadd4191b9beb388aa23c) (2015-05-29)

##### New Features
  - Threw in a tile .PNG for future use
  - Started framework for GameObjects and Entities (objects package for now)

### [Version 0.0.3](https://github.com/backfrip/MKS22X-Final-Project/commit/7f0affecd7499bd8754386ab58eff40b0d74166e) (2015-05-25)

##### New Features
  - Basic Game and Screen setup, threw in a counter for testing
  - Added referenced library sources for documentation

### [Version 0.0.2](https://github.com/backfrip/MKS22X-Final-Project/commit/4642ace9131e8be575b635b59476ec1a430fc1f9) (2015-05-21)

##### New Features
  - Threw in the old .gitignore
  - Hacked together another libGDX project structure

### [Version 0.0.1](https://github.com/backfrip/MKS22X-Final-Project/commit/4593b59ec9c0b2b9b07c94e44430c47f8f78822c) (2015-05-15)

##### New Features
  - Sweet looking README formatting
