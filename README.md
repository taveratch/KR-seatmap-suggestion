# KR-seatmap-suggestion

To run the code:
  1. Compile the file Main.class
      `javac -cp jpl.jar Main.java`
  2. Locate `libswipl.so` (ubuntu) or `libswipl.dylib` (OSX)
      
      usually it is located at `/usr/lib/` on ubutu
  3. Run the program
      `java -cp jpl.jar: Djava.library.path={location of libswipl} Main`
