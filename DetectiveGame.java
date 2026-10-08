package Class_assignment;

public class DetectiveGame {
    public static void main(String[] args) {
        // create suspects
        Suspect one = new Suspect(1, "Alex", "Computer Lab", "Working on a project");
        Suspect two = new Suspect(2, "Maya", "Library", "Studying");
        Suspect three = new Suspect(3, "Rahul", "Staff Room", "Meeting a faculty member");
        Suspect four = new Suspect(4, "Sara", "Canteen", "Having lunch");
        Suspect five = new Suspect(5, "Arjun", "Department Office", "Collecting documents");
        
        Suspect[] suspects = {one, two, three, four, five};

        // create clues
        Suspect clue1 = new Suspect("The office door was opened at 2:15 PM.");
        Suspect clue2 = new Suspect("CCTV shows someone entering the office.");
        Suspect clue3 = new Suspect("A torn piece of paper was found near the printer.");
        Suspect clue4 = new Suspect("A suspect's ID card was found inside the office.");
        Suspect clue5 = new Suspect("The printer was used shortly before the question paper disappeared.");
        
        Suspect[] clues = {clue1, clue2, clue3, clue4, clue5};

        // setup investigation with actual culprit ID 3
        Investigation investigation = new Investigation(3);

        // simulate user inputs (no scanner yet)
        int[] simulatedChoices = {1, 3, 4, 2, 5, 6};
        int step = 0;
        boolean running = true;

        while (running && step < simulatedChoices.length) {
            System.out.println("\n=================================");
            System.out.println("     DETECTIVE INVESTIGATION     ");
            System.out.println("=================================");
            System.out.println("1. View Suspects");
            System.out.println("2. Investigate Suspect");
            System.out.println("3. Collect Clue");
            System.out.println("4. View Collected Clues");
            System.out.println("5. Accuse Suspect");
            System.out.println("6. Exit");

            int choice = simulatedChoices[step];
            System.out.println("\n[Simulated Detective Choice: " + choice + "]");

            switch (choice) {
                case 1:
                    Suspect.displaySuspect(suspects);
                    break;
                    
                case 2:
                    int investigateId = 3; 
                    System.out.println("> Investigating Suspect ID: " + investigateId);
                    investigation.investigateSuspect(suspects, investigateId);
                    break;
                    
                case 3:
                    int clueIdx = 2; 
                    System.out.println("> Collecting Clue Number: " + (clueIdx + 1));
                    Suspect.CollecteClue(clues, clueIdx);
                    break;
                    
                case 4:
                    // pass 0 as a dummy argument
                    Suspect.DisplayCollectedClue(clues, 0); 
                    break;
                    
                case 5:
                    int accuseId = 3; 
                    System.out.println("> Accusing Suspect ID: " + accuseId);
                    boolean solved = investigation.accuseSuspect(accuseId);
                    if (solved || investigation.attemptsFinished()) {
                        running = false;
                    }
                    break;
                    
                case 6:
                    System.out.println("> Exiting the investigation...");
                    running = false;
                    break;
                    
                default:
                    System.out.println("> Invalid choice.");
            }
            
            step++;
        }
    }
}
