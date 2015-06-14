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

### [Version 0.2.0](../../commit/5acef5f3e12faf02250563fab34ec53426431210) (2015-06-08)

#### New Features
  - Adjusted 2D Iso rendering, game now starts in this orientation
  - Changed movement mechanics so that it moves relative to player
  - Began working on an opening screen to game, user can switch from this intro screen to game screen
  - Downloaded image to put as background to intro screen

#### Features Planned for Future
  - Adding audio and text to intro screen
  - Movement relative to mouse instead of to player

### [Version 0.1.4](../../commit/5acef5f3e12faf02250563fab34ec53426431210) (2015-06-08)

#### New Features
  - Figured out equation that translated the map into 2D isometric
  - Adjusted Camera in relationship to new orientation
  - Updated QuadTree to make working on collisions later on easier

#### Features Planned for Future
  - Implementing old features such as fullscreen and restart from 2D Map to 2D Isometric
  - Adjust movement to complement 2D Isometric plane

### [Version 0.1.3](../../commit/35e4f36fb999798410720cbc66154927c70a03c8) (2015-06-07)
  
#### New Features
  - Added new blankspace.omap to test code
  - Began working with Space2D to create different screens

### [Version 0.1.2](../../commit/7c9e4a420047b96e8a6106b9668cb56141b9265f) (2015-06-05)

#### New Features
  - Created basic item class
  - Mutator and Accessor Methods for MovingEntity

### [Version 0.1.1](../../commit/cae101195293a20cad6752567608ca39e0db2505) (2015-06-02)

#### New Features
  - User can switch between maps by pressing "M"
  - User can restart game by pressing "R"
  - Instructions displayed to assist player

### [Version 0.1.0](../../commit/0ef1e1b757833da5178a2ce3382c5bb4cec58240) (2015-06-01)

#### New Features
  - Added a Diagnostic screen to debug entities on a 2D grid before moving to isometric
  - Created a Map class to hold information about map cells
  - Implemented rendering of map
  - Use can now toggle fullscreen by pressing space
  - Improved movement and collision mechanics

#### Features Planned for Future
  - Player and Monster classes
  - Pickup Items 
  - Rendering an Isometric map


### [Version 0.0.6](../../commit/3d069dd682fb15df80a074361e6cb16aff0a6c32) (2015-05-31)

##### New Features
  - Added basic movement and collision systems for player debugging, only for temporary testing
  - Swapped FillViewport for ExtendViewport to avoid cropping
  - General refactoring

##### Features Planned for the Very Near Future
  - Enemies to populate the map
  - A QuadTree data structure to reduce collision checks

### [Version 0.0.5](../../commit/22ee25592d65b90103b5e469cbcc1ed329219e08) (2015-05-30)

##### New Features
  - Added transparency to resource/img/tile.png
  - Added more configuration settings to launcher class (Main.java), plan to make them adjustable in-game and recall on startup
  - Allowed for fullscreening (press space for now), FillViewport auto-resizes and crops
  - Tile rendering test

### [Version 0.0.4](../../commit/c94bc713634837ce4ccfadd4191b9beb388aa23c) (2015-05-29)

##### New Features
  - Threw in a tile .PNG for future use
  - Started framework for GameObjects and Entities (objects package for now)

### [Version 0.0.3](../../commit/7f0affecd7499bd8754386ab58eff40b0d74166e) (2015-05-25)

##### New Features
  - Basic Game and Screen setup, threw in a counter for testing
  - Added referenced library sources for documentation

### [Version 0.0.2](../../commit/4642ace9131e8be575b635b59476ec1a430fc1f9) (2015-05-21)

##### New Features
  - Threw in the old .gitignore
  - Hacked together another libGDX project structure

### [Version 0.0.1](../../commit/4593b59ec9c0b2b9b07c94e44430c47f8f78822c) (2015-05-15)

##### New Features
  - Sweet looking README formatting
