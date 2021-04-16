# AI-Final-Project
Repository for our final project in Artificial Intelligence

Old School Runescape Reinforcement Learning Agent Project
Authors: Declan Jeffrey, Shane Phillips, Wren Maybury

Meeting # 1 (3/21/2021)
Notes:
  Start with tree cutting, Q-learning agent. 
  Posisbly move to more advance task, like combat if possible. 
  Learn how to read/write to file so you can save weights/values of states (or do we?)
  Other forms of RL? 
  Possibility: Combing tasks to optimize getting gold or exp
  Show progress from:
    Basic AI
    Basic AI that performs tasks
    Basic AI with RL to improve certain tasks and optimize getting materias
    RL AI that can perform multiple tasks and optimize something general like getting gold or exp
    RL AI that can perform combat, optimizing living, defeating enemies, gaining exp
    (May not get a fully functional combat AI, but show progress and difficulties in report )
  Take into account leveling up. Some tree/rocks/other materials can only be mined at a certain level but give more exp.
  Restrict search area to smaller section so he doesn't wonder the whole map

Progress:
  Watched videos to create our own general AI that can navigate the environment and perform basic tasks
  Created Final Report copy in open leaf, and started editing
  Coded the ability to find the closest trees and tell us what it is and where it is
  
  Meeting #2 (3/28/2021)
  Progress:
    -Made agent find the nearest tree and go cut it down. 
    *How do we make the agent go to the best tree, not necessarily the closest. (has to go around walls and take a longer path, while passing other trees)
    -Include some sort of epsilon? Where he may chose to explore and go to a random tree, or randomly deposit the resources. 
    
  TO DO:
    -Conditions for being high enough level, having an axe, someone else interacting with the tree
    -Finding the real closest tree , not having to go around walls 
    -Q-Learning : 
      + Actions : (go to tree, chop tree, deposit)
      + Rewards : (gold , amount of lumber, experience)
      + Punishments : (time, distance)
    -Select starting space and create episode of cutting trees and depositing, learn based on how good they are. 
  
  Meeting #3 (4/4/2021)
  Progress:
    -Finished polishing off the basic lumber collecter. 
      *Jumping off point. Something to gain info from, gain base data. 
    -Started trying to implement Q-learning into the agent.
      *Do we need a reinforcement learning agent class? Or can we just implement a Q-learning class and have all the necessary info in there?

  TO DO/ CONSIDER: 
    -Q-learning class: evalue state action pairs. Determine the best action based on those state, action pairs. 
      *Learning rate, epsilon, discount
      *When determing the "Closest" tree, don't base off of something generic like manhattan distance, but the actualy path length to get there.
    -3 basic agents: Lumber, Mining, Fishing
      *Fishing = Probability of getting different fish, so that would affect the exp/gold gained. 
      *Restrict search area/ Allow for the use of additional banks 
      *Episodes can be based on starting -> getting resources -> and banking. 
       Our final agent will ideally not just bank when his inventory is full,  but when it is the most optimal action (or randomly/epsilon). 
       The performance of the Q-learning agent should then be based on how quickly he was able to collect those resources/gold/exp and bank them. 
       Whereas the performance of the baseline agents is just based on how quickly they can fill up their inventory and bank it. 
      *Consider respawn rate of resources, how would that work? 
    -3 Q-learning agents: Lumber, Mining, Fishing
    -POSSIBLY: Combat. See how the other 3 go, and maybe try and dabble with the combat a little
    -1 basic agent that can collect all 3 resources
    -1 Q-learning agent that can optimize gold and exp while collecting all the resources. 
    -Consider epsilon, and the idea of exploration. Not necessarily just always cutting the cloest tree. 
    -Text File with learned Q-values , And another to store the baseline so we can re learn when we want to 
    
 Meeting #4 (4/9/2021)
 Progress:
  - Got the baseline agent finalized. With GUI displaying path to tree agent is going to, as well as displaying time taken in each episode. 
  - Also fixed pathing issue of finding closest tree but wasnt really (closest manhattan distance)
  - Worked on report, got a good baseline for that as well. Set up tables to store information of q-learning agents episodes. 
 TO DO/Consider
  -Make other 2 baseline agents (shouldn't be too bad)
  -Start implementing Q-learning. 
    + List of actions should include not just closest tree, but a list of the top 10-20 cloest trees. 
    + There should then be some epsilon, meaning a random chance to not go to the seemingly optimal solution but explore a different close tree. 
    + By going to a random tree, the agent learns the value of that action. Is it going to be the new optimal action? Or is it not worth it?
    + How many runs do we need? 5, 10, 50, 100? -> Is there a limit, and does OSBOT stop you from running that many times. 

Meeting #5 (4/16/2021)

Progress:
  + Even more problems with getting OS BOT working on Declan's computer. Keeps giving us trouble when trying to set up java, not sure why. 
  + Started implementing Q-learning into the wood cutting agent
  + Base file = agent class (Woodcutter, fishing, mining)
  + AI FINAL PROJECT file = reinforcement learning agent class 
  + Q learning file = q learning agent file
  + State class -> Class to store the state information (player position, player health, list of close trees, list of close enemies, list of close player)
  + Actions -> Probably good to just store in a data structre -> (go to tree, chop the tree/mine, deposit materials, movement)
  + Do we want to store learned values in a txt file? That would mean he does not start from square zero when learning on each start of the learning. 
  + State Class:
    - Things to consider in state: Playe position, trees aroung that position, enemies around that position, players health  
    - Epsilon -> Going to never before seen trees 
  
 TODO/Consider
  + Finish Q-learning for wood cutter
  + Is it too comlicated? Or can we apply it to other tasks. 
  +
