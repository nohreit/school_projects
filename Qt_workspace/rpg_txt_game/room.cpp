#include "room.h"

Room::Room(){
    this->roomIndex = 0;
    this->description = "";
    this->monster = Monster();
}
Room::Room(int roomIndex, string description, Monster monster)
{
    this->roomIndex = roomIndex;
    this->description = description;
    this->monster = monster;
}

bool Room::isComplete(){
    return !monster.isAlive() ? true : false;
}

void Room::enter(Creature player){
    cout << player.getName() << "\nThis Room is " <<
             this->description << ", and has...\n" <<
            this->monster.getName() <<endl;
}

string Room::toString(){
    return "Room index: "+ to_string(this->roomIndex)+ ", Description: "
            + this->description + ", Monster name: " + monster.getName();
}


