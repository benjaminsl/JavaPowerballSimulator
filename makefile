all:
	javac Main.java
	javac LotteryMath.java
	javac TimeConversions.java
	javac WindowMethods.java
	java Main

main:
	javac Main.java

lotterymath:
	javac LotteryMath.java
	
timeconversions:
	javac TimeConversions.java
	
windowmethods:
	javac WindowMethods.java

make clean:
	rm *.class
	
run:
	java Main
