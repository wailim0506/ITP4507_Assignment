# ITP4507 Assignemnt (Semester 1, 2024-2025)

This project aim to apply Open-closed principle and Design patterns

## Task Specification

<p style="font-size: 15px">Snow Storm Company develops an RPG game "Fantastic World (FW)" on the PC. The major characters in
this game are known as HERO and they have various kinds of characteristic. For example, Warrior focus on
defence and Warlock target on magic damage. Each player in this game can play more than one hero.
Currently, this game only has Warrior and Warlock. In the coming future, this game will be extended to
support more kinds of hero such as healer. The following is the simplified class diagram of existing data
maintained by FW.</p>
<img width="737" alt="classDiagram" src="https://github.com/user-attachments/assets/c55a2c9b-dbe0-4197-884c-a6a1b106e8a8">
<p style="font-size: 15px">As a system analyst of the Company, you are required to design and develop FW. You can get the source
codes of above classes from Moodle.
FW should provide the following functions:</p>
    <ol style="font-size: 14px">
        <li>Create a Player.</li>
        <li>Add a hero (Warrior or Warlock) to the current player.</li>
        <li>Remove a hero from the current player.</li>
        <li>Select a player by using a player ID.</li>
        <li>Call a hero's skill by a hero ID.</li>
        <li>Show the detail information of current player.</li>
        <li>Change the player's name of the current player.</li>
        <li>Show all players.</li>
        <li>Set current player.</li>
        <li>Undo last command.</li>
        <li>Redo the last undone command.</li>
        <li>Show undo/redo list.</li>
        <li>Exit System.</li>
    </ol>
<p style="font-size: 15px">Your system design should conform to the Open Closed Principle so that your design should easily be
extended to support new heroes (for examples, healers, rangers etc..).</p>

<p style="font-size: 15px">You MUST apply the following design patterns for your new system:</p>
    <ul style="font-size: 14px">
        <li>Command pattern to provide the “create player”, “set current player”, “add hero”,
        “call hero skill”, “delete hero”, “show current player”, “display all players”, “change player’s
        name”. “undo”, “redo” and “show undo/redo list” functions</li>
        <li>Factory pattern or Abstract Factory Pattern to create different kinds of Command objects and
        different kinds of Player/Hero objects (e.g., Warrior object, Warlock object, Player object, etc.)</li>
        <li>Memento pattern to provide “Undo” and “Redo” functions on the “call hero skill” and “change
        player’s name” functions.</li>
    </ul>