all:
	javac -O ./*/*.java

clean:
	rm ./*/*.class

run:
	java Emulator.JavaBoy