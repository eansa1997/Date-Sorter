package project4;
/**
 * 
 * A class that stores a date as year,month, and date.
 *
 */
public class Date212{
    private int year;
    private int month;
    private int day;
    private int date;
    /**
     * Takes a string and reads it into the private int variables, throws exception if invalid.
     * @param date A string to be read.
     * @throws Date212Exception An exception thrown.
     */
    public Date212(String date) throws Date212Exception{
        year = Integer.parseInt(date.substring(0, 4));
        month = Integer.parseInt(date.substring(4, 6));
        day = Integer.parseInt(date.substring(6, 8));
        this.date = Integer.parseInt(date);
        if(isValid() == false){ //checks if data is valid, throws exception if it isnt.
            throw new Date212Exception("The date: "+ toString() +" is invalid. It will not be included in lists.");
        }
    }
    /**
     * This method overrides the toString method takes the Date212 variables and displays it in a specific 
     * format
     * @return Returns a String.
     */
    @Override
    public String toString(){
        return "" +month + "/" + day + "/" +year;
    }
    /**
     * This method returns the year.
     * @return Returns the year int variable.
     */
    public int getYear(){
        return this.year;
    }
    /**
     * This method returns the month.
     * @return Returns the month int variable.
     */
    public int getMonth(){
        return this.month;
    }
    /**
     * This method returns the day.
     * @return Returns the day int variable.
     */
    public int getDay(){
        return this.day;
    }  
    /**
     * This method returns the entire date as an int.
     * @return Returns the date int variable.
     */
    public int getDate(){
        return this.date;
    }
    /**
     * This method compares the passed in object to the current object and returns the proper values for a Comparator.
     * @return Returns a negative/zero/positive int.
     * @param in A Date212 object.
     */
    public int compareTo(Date212 in){
        if( this.date < in.date)
            return -1;
        else if( this.date > in.date)
            return 1;
        else
            return 0;
    }
    /**
     * This method checks if the month and day are valid.
     * @return Returns true if date is valid and false otherwise.
     */
    public boolean isValid(){
        if(month < 1 || month > 12){   //checks if month is between 1-12
            return false;
        }
        if(month == 1){  // matches each month and checks if its in the appropriate date range
            if(day < 1 || day > 31)
                return false;
        } else if(month == 2){
            if(day < 1 || day > 28)
                return false;
        } else if(month == 3){
            if(day < 1 || day > 31)
                return false;
        } else if(month == 4){
            if(day < 1 || day > 30)
                return false;
        } else if(month == 5){
            if(day < 1 || day > 31)
                return false;
        } else if(month == 6){
            if(day < 1 || day > 30)
                return false;
        } else if(month == 7){
            if(day < 1 || day > 31)
                return false;
        } else if(month == 8){
            if(day < 1 || day > 31)
                return false;
        } else if(month == 9){
            if(day < 1 || day > 30)
                return false;
        } else if(month == 10){
            if(day < 1 || day > 31)
                return false;
        } else if(month == 11){
            if(day < 1 || day > 30)
                return false;
        } else if(month == 12){
            if(day < 1 || day > 31)
                return false;
        }
        return true;
    }
}
