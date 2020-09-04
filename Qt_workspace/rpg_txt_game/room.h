#ifndef ROOM_H
#define ROOM_H
#include <iostream>
#include "monster.h"
#include "player.h"

using namespace std;

class Room: public Player
{
private:
    int roomIndex;
    string description;
    Monster monster;
public:
    Room();
    Room(int, string, Monster);
    bool isComplete();
    void enter(Creature);
    string toString();
};

#endif // ROOM_H
