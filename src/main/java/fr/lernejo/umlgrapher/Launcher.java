package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

class Launcher implements Callable<Integer> {

    @Option(names = {"-c", "--classes"},required = true, description = "description de classes")
    private Class<?>[] classes;

    @Option(names = {"-g", "--graph_type"}, description = "type de graph")
    private final GraphType graphType = GraphType.Mermaid;

    @Override
    public Integer call() throws Exception { // your business logic goes here..

        UmlGraph umlGraph = new UmlGraph(classes);
        String sortie = umlGraph.as(graphType);
        System.out.println(sortie);
        return 0;
    }
    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }

    public void setClasses(Class<?>[] classes) {
        this.classes = classes;
    }
}
