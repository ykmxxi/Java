package ch15.문자기반스트림;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class PipedReaderWriter {
    public static void main(String[] args) {
        InputThread inputThread = new InputThread("InputThread");
        OutputThread outputThread = new OutputThread("OutputThread");

        inputThread.connect(outputThread.getOutput());

        inputThread.start();
        outputThread.start();

    }
}

class InputThread extends Thread {
    PipedReader input = new PipedReader();
    StringWriter writer = new StringWriter();

    public InputThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int data = 0;

            while ((data = input.read()) != -1) {
                writer.write(data);
            }
            System.out.println(getName() + " received : " + writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedReader getInput() {
        return input;
    }

    public void connect(PipedWriter output) {
        try {
            input.connect(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class OutputThread extends Thread {
    PipedWriter output = new PipedWriter();

    public OutputThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            String msg = "Hello";
            System.out.println(getName() + " sent : " + msg);
            output.write(msg);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedWriter getOutput() {
        return output;
    }

    public void connect(PipedReader input) {
        try {
            output.connect(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
