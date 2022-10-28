package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;


class Launcher implements Callable<Integer> {

    @Option(names = {"-c", "--classes"},required = true, description = "renseigner les classes d'où faire partir l'analyse")
    private final Class<?>[] user_class = {};

    @Option(names = {"-g", "--graph-type"}, description = "sélectionner le type de graph")
    private final GraphType graphType = GraphType.Mermaid;

    @Override
    public Integer call() throws Exception {

        UmlGraph umlGraph = new UmlGraph(user_class);
        String sortie = umlGraph.as(graphType);
        System.out.println(sortie);
        return 0;
    }


    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
