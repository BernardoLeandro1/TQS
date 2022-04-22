package euromillions;

import java.util.Objects;

import sets.SetOfNaturals;

import java.util.Random;

import java.util.Arrays;


/**
 * A set of 5 numbers and 2 starts according to the Euromillions ranges.
 *
 * @author ico0
 */
public class Dip {

    final static int MAX_NUMBER_OF_NUMBERS = 5;
    final static int MAX_NUMBER_OF_STARS = 2;

    final static int NUMBER_MIN = 1;
    final static int STAR_MIN = 1;
    final static int NUMBER_MAX = 50;
    final static int STAR_MAX = 12;


    private SetOfNaturals numbers;
    private SetOfNaturals starts;

    public Dip() {
        numbers = new SetOfNaturals();
        starts = new SetOfNaturals();
    }

    public Dip(int[] arrayOfNumbers, int[] arrayOfStarts) {
        this();

        if (MAX_NUMBER_OF_NUMBERS != arrayOfNumbers.length || MAX_NUMBER_OF_STARS != arrayOfStarts.length)
            throw new IllegalArgumentException("wrong number of elements in numbers/stars");

        if (!Arrays.stream(arrayOfNumbers).allMatch(this::validNumber) || !Arrays.stream(arrayOfStarts).allMatch(this::validStar))
            throw new IllegalArgumentException("numbers/stars are out of range");

        numbers.add(arrayOfNumbers);
        starts.add(arrayOfStarts);
    }

    private boolean validNumber(int number) {
        return number >= NUMBER_MIN && number <= NUMBER_MAX;
    }

    private boolean validStar(int star) {
        return star >= STAR_MIN && star <= STAR_MAX;
    }

    public SetOfNaturals getNumbersColl() {
        return numbers;
    }

    public SetOfNaturals getStarsColl() {
        return starts;
    }

    public static Dip generateRandomDip() {
        Random generator = new Random();

        Dip randomDip = new Dip();
        for (int i = 0; i < MAX_NUMBER_OF_NUMBERS; ) {
            int candidate = generator.nextInt(NUMBER_MAX) + NUMBER_MIN;
            if (!randomDip.getNumbersColl().contains(candidate)) {
                randomDip.getNumbersColl().add(candidate);
                i++;
            }
        }
        for (int i = 0; i < MAX_NUMBER_OF_STARS; ) {
            int candidate = generator.nextInt(STAR_MAX) + STAR_MIN;
            if (!randomDip.getStarsColl().contains(candidate)) {
                randomDip.getStarsColl().add(candidate);
                i++;
            }
        }
        return randomDip;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.numbers);
        hash = 29 * hash + Objects.hashCode(this.starts);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dip other = (Dip) obj;
        if (!Objects.equals(this.numbers, other.numbers)) {
            return false;
        }
        return Objects.equals(this.starts, other.starts);
    }


    /**
     * prepares a string representation of the data structure, formated for
     * printing
     *
     * @return formatted string with data
     */
    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append("N[");
        for (int number : getNumbersColl()) {
            sb.append(String.format("%3d", number));
        }
        sb.append("] S[");
        for (int star : getStarsColl()) {
            sb.append(String.format("%3d", star));
        }
        sb.append("]");
        return sb.toString();
    }
}
