package ü1a1;

public class Helper {

    public static void move(Buffer source, Buffer sink) {

        while(source.size() > 0){
            sink.push(source.pop());
        }
    }
}