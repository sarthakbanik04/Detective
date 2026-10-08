package Class_assignment;

public class DetectiveGame {
    public static void main(String[] args) {
        // 1. Initialize predefined suspects (Integrating Student 1's work)
        Suspect one = new Suspect(1, "Alex", "Computer Lab", "Working on a project");
        Suspect two = new Suspect(2, "Maya", "Library", "Studying");
        Suspect three = new Suspect(3, "Rahul", "Staff Room", "Meeting a faculty member");
        Suspect four = new Suspect(4, "Sara", "Canteen", "Having lunch");
        Suspect five = new Suspect(5, "Arjun", "Department Office", "Collecting documents");
        
        Suspect[] suspects = {one, two, three, four, five};

        // 2. Initialize predefined clues (Integrating Student 2's current implementation)
        Suspect clue1 = new Suspect("The office door was opened at 2:15 PM.");
        Suspect clue2 = new Suspect("CCTV shows someone entering the office.");
        Suspect clue3 = new Suspect("A torn piece of paper was found near the printer.");
        Suspect clue4 = new Suspect("A suspect's ID card was found inside the office.");
        Suspect clue5 = new Suspect("The printer was used shortly before the question paper disappeared.");
        
        Suspect[] clues = {clue1, clue2, clue3, clue4, clue5};

        // 3. Initialize Investigation (Integrating Student 3's work)
        // Let's set the actual culprit ID to 3 (Rahul)
        Investigation investigation = new Investigation(3);

        // 4. Predefined simulated choices since Scanner is not allowed
        // 1: View Suspects
        // 3: Collect Clue
        // 4: View Collected Clues
        // 2: Investigate Suspect
        // 5: Accuse Suspect
        // 6: Exit
        int[] simulatedChoices = {1, 3, 4, 2, 5, 6};
        int step = 0;
        boolean running = true;

        // 5. Main investigation loop
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

            // 6. Switch statement for menu selection
            switch (choice) {
                case 1:
                    Suspect.displaySuspect(suspects);
                    break;
                    
                case 2:
                    int investigateId = 3; // Predefined suspect ID to investigate
                    System.out.println("> Investigating Suspect ID: " + investigateId);
                    investigation.investigateSuspect(suspects, investigateId);
                    break;
                    
                case 3:
                    int clueIdx = 2; // Predefined clue index to collect
                    System.out.println("> Collecting Clue Number: " + (clueIdx + 1));
                    Suspect.CollecteClue(clues, clueIdx);
                    break;
                    
                case 4:
                    // Passing 0 as idx because the existing method requires an int argument but doesn't use it correctly for display all
                    Suspect.DisplayCollectedClue(clues, 0); 
                    break;
                    
                case 5:
                    int accuseId = 3; // Predefined suspect ID to accuse
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
