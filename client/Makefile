CFLAGS = -Wall -O2 -g
CXXFLAGS = $(CFLAGS)

%: player.a %.c
	$(CC) $(CFLAGS) -o $@ $^ -lstdc++

%: %.cc player.a
	$(CXX) $(CXXFLAGS) -o $@ $^

%: %.cpp player.a
	$(CXX) $(CXXFLAGS) -o $@ $^

all: mybot1 mybot2 mybot3 mybot4

player.a: client.o spies_library.o
	rm -f $@
	$(AR) qc $@ $^

mybot%: player.a mybot%.c
	$(CC) $(CFLAGS) -o $@ $^ -lstdc++

mybot%: player.a mybot%.cc
	$(CXX) $(CXXFLAGS) -o $@ $^

clean:
	rm -f *.o *.a

#dist:
#	rm -f agents.tar.gz
#	mkdir agents
#	cp -a mybot?.c skeleton.c player.h player-main.c client.c librally.c rally.h Makefile watcher-main.c pretty.c agents
#	tar czf agents.tar.gz agents
#	rm -rf agents
