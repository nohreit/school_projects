#ifndef TREASUREROOM_H
#define TREASUREROOM_H
#include <iostream>
#include "room.h"
#include "monster.h"

using namespace std;

class TreasureRoom: Room
{
private:
    string treasure;
public:
    TreasureRoom(string, Monster*, string);
};

#endif // TREASUREROOM_H
