import java.util.Calendar;

public class Scheduler {
    Calendar now = Calendar.getInstance();
    String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
            "Friday", "Saturday" };
    private String[] strMonths = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
        "Sep", "Oct", "Nov", "Dec" };
    private String currentMonthString = strMonths[now.get(Calendar.MONTH)];
    private int currentMonthInt = (now.get(Calendar.MONTH) + 1);
    private int currentDateInt = now.get(Calendar.DATE);
    private int currentYearInt = now.get(Calendar.YEAR);
    private String currentDayString = strDays[now.get(Calendar.DAY_OF_WEEK) - 1];
    private  int lastDate = now.getActualMaximum(Calendar.DATE);
    private int lastDay = now.get(Calendar.DAY_OF_WEEK);
    private int weekOfMonth= now.get(Calendar.WEEK_OF_MONTH);
    private int weekOfYear= now.get(Calendar.WEEK_OF_YEAR);
    private int days = now.getActualMaximum(Calendar.DAY_OF_MONTH);
	
    public void setDate(){
    	Calendar calendar = Calendar.getInstance();
    	calendar.clear();
    	calendar.set(2001, 1, 1);
    }
    public boolean isLeapYear(int year) {

        if (year < 0) {
          return false;
        }

        if (year % 400 == 0) {
          return true;
        } else if (year % 100 == 0) {
          return false;
        } else if (year % 4 == 0) {
          return true;
        } else {
          return false;
        }
      }
  
    
    

}