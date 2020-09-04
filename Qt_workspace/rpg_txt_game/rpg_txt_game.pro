TEMPLATE = app
CONFIG += console c++11
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += \
        battle.cpp \
        creature.cpp \
        main.cpp \
        monster.cpp \
        player.cpp \
        room.cpp \
        treasureroom.cpp

HEADERS += \
    battle.h \
    creature.h \
    monster.h \
    player.h \
    room.h \
    treasureroom.h
