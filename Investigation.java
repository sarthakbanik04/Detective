package Class_assignment;

public class Investigation {
    int actualCulpritID;
    int accusationAttempts;
    Investigation(int actualCulpritID) {
        this.actualCulpritID = actualCulpritID;
        this.accusationAttempts = 0;
    }
    public Suspect searchSuspect(Suspect[] suspects, int suspectID) {

        for (Suspect suspect : suspects) {

            if (suspect != null && suspect.ID == suspectID) {
                return suspect;
            }
        }

        return null;
    }
    public void investigateSuspect(Suspect[] suspects, int suspectID) {

        Suspect suspect = searchSuspect(suspects, suspectID);

        if (suspect != null) {

            System.out.println("----- INVESTIGATING SUSPECT -----");
            suspect.dispaly();

        } else {

            System.out.println("Suspect with ID "
                    + suspectID + " not found.");
        }
    }

    public boolean accuseSuspect(int accusedID) {

        if (accusationAttempts >= 3) {

            System.out.println("INVESTIGATION FAILED!");
            System.out.println("You have used all three attempts.");
            System.out.println("The culprit escaped.");

            return false;
        }
        accusationAttempts++;

        System.out.println("----- ACCUSATION -----");
        System.out.println("Accusation Attempt: " + accusationAttempts);
        if (accusedID == actualCulpritID) {

            System.out.println("CASE SOLVED!");
            System.out.println("You identified the culprit.");
            System.out.println("The missing question paper has been recovered.");

            return true;

        } else {

            System.out.println("Incorrect accusation.");

            if (accusationAttempts < 3) {

                System.out.println("You have "
                        + (3 - accusationAttempts)
                        + " attempt(s) remaining.");

            } else {

                System.out.println("INVESTIGATION FAILED!");
                System.out.println("You have used all three attempts.");
                System.out.println("The culprit escaped.");
            }

            return false;
        }
    }
    public boolean attemptsFinished() {

        return accusationAttempts >= 3;
    }
}
