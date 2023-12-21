import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // инициализация списка игрушек
        ToyList toys1 = new ToyList();
        toys1.addToy(new Toy(25, "Tractor", 3));
        toys1.addToyList(List.of(
                new Toy(5, "Car", 1),
                new Toy(10, "Crocodile", 2),
                new Toy(10, "Chocolate", 2)));
        System.out.println(toys1);
        // инициализация очереди
        ParticipantQueue pq = new ParticipantQueue(List.of(
                new Participant("1"),
                new Participant("2"),
                new Participant("3"),
                new Participant("4"),
                new Participant("5"),
                new Participant("6"),
                new Participant("7"),
                new Participant("8"),
                new Participant("9"),
                new Participant("10")));

        Raffle raf = new Raffle(pq, toys1);
        System.out.println(raf.currentToys.toString());
        raf.runRaffle();

        System.out.println("\nРозыгрыш с вероятностью проиграть\n");
        ParticipantQueue pqloss = new ParticipantQueue();
        for (int i = 1; i <= 10; i++) {
            pqloss.addParticipant(new Participant());
        }
        Raffle raf2 = new Raffle(pqloss, toys1);
        raf2.setLossWeight(30);
        System.out.println(raf2.currentToys.toString());
        raf2.runRaffle();

        toys1.saveToFile();
    }

}
