# Teregeon 
  \~brought to you by Tortugas En Llamas~ (Calvin made that name)
  
Ever wished for a fun game you can use your terminal to open? (I doubt it) well look no further!! We plan to create a NetHack-like game that draws inspiration from projectile-hell roguelike games such as Enter the Gungeon and Soul Knight. While there might be some spotty features due to our graphics being stuck in ascii-art, we hope you are pleased with this game.
# How to play
  So how do I play this very enticing and awesome game that will definitely be worth my time? You might ask yourself. Well good thing you decided to continue reading the file literally named "readme". first to play this game you must compile and run the Game.java file present in this repository with lanterna(3).jar in your classpath. You can do this by typing in "./run.sh". If there are compatibility issues, you must resort to manually running the game. Or if you are too lazy you can copy and paste this (javac lanterna(3).jar:." Game.java && java -cp "lanterna(3).jar:." Game) for linux and this (javac lanterna(3).jar;." Game.java && java -cp "lanterna(3).jar;." Game) for git bash. (and yes we just changed the colons to semicolons right there). Next to play this game that will definitely not be a waste of time and enlighten you beyond the reach of other mortals around you, you must read all the directions. For even though you must have a highly advanced intellect for deciding to play this game you will not be able to fully aprreciate it without reading the directions.
 # Directions
  1. Use the wasd keys for vertical/horizontal movement, and qezx for diagonal movement
  2. Press the esc key to leave at any time
  3. We have labored day and night to be able to tell you that resizing the screen in-game will not affect it at all however if you rapidly change the size it will crash the game
  4. Press the space bar to shoot in the direction of the closest enemy (keep in mind this feature is very spotty as it is based upon the center of the enemy and it is hard to get good aiming in a terminal game)
  - Kill all the enemies and the boss to win!
# Pro-tips
1. The boss room is always on the other corner of the map from the spawn room
2. Try to shoot the enemies while standing vertically/horizonatally from them
# Logs
<p>Day 1 (1/3/19):
  we learned how to use lanterna, to place strings down and stuff
 </p>
<p>Day 2 (1/4/19):
  we started creating the graphics class and adding sprites to it
  -> finished adding sprite models for the player, small enemy, medium enemy, and (temp) large enemy
</p>
<p>Day 3 (1/5/19):
  we made the following changes to the graphics class:
  - the small enemy was demoted to a tiny enemy
  - the medium enemy was demoted to a small enemy
  - the large enemy was promoted to a boss
  - a new medium enemy sprite was created
  - a new large enemy sprite was created
 </p>
<p>Day 4 (1/6/19):
  - made the player view display to the screen, that got a section of the entire map
  - allowed movement with the wasd keys and qezx for diagonal movement
  - fixed broken room designs + started adding lava pits to battle rooms and introduced colored array
</p>
<p>Day 5 (1/7/19):
  - changed lava pool to a random spawning algorithm that generates random pits of lava
  - created a basic boss room layout
  - organized pre-existing code
  - small tweak to treasure room
  - got started on game.java
</p>
<p>Day 6 (1/8/19):
  - revamped Room class as it was rather unorganized and not executed optimally
  - added comments to Room class
  - began colored array in Graphics class to assign colors to sprites
  - fixed game.java to display a view of the correct coordinates 
  - made map gen add a border where the player cannot go
</p>
<p>Day 7 (1/10/19):
  - started Player, Person, and Bullet classes
</p>
<p>Day 8 (1/11/19):
  - converted to Lanterna 3.0
  - developed more of Player, Person, Bullet, Weapon, and WeaponList classes
  - added a new BulletType class to store properties of bullets
</p>
<p>Day 9 (1/12/19):
  - fixed up Game.java for movement (continuous and otherwise)
  - developed colors for the graphics
  - color maps added to each sprite & created test main for graphics to view colored sprites
</p>
<p>Day 10 (1/18/19):
  - started random map generation: 4 spawn+boss variations, rooms randomly placed
  - fixed problem of rooms being able to spawn inside each other in the case that they fit inside another's walls
  - fixed screen resizing
  - fixed infinite looping that sometimes occurs when attempting to fit rooms (added max attempts for room placements)
</p>
<p>Day 11 (1/20/19):
  - scrapped old mapgen for new one based on a grid fashion
  - spawnroom and bossroom spawn on opposite corners, rest of the rooms are randomly chosen and placed on "grid"
  - hallways connecting rooms added
  - made sprites odd numbered dimensions and minor tweaks to graphics
  - boss room fixed
  - added enemies to the map
  - made the enemies move randomly
  - made sure that resizing the screen doesn't affect the enemies 
</p>
<p>Day 12 (1/21/19):
  - added shooting and shooting algorithms
  - added player and enemy attributes
  - added taking damage and health
  - added regeneration
  - added Boss to the map
  - added more comments
  - finalized game
</p>
