class sleeplog {
	String date;
	String starttime;
	String endtime;
    int[] sleeplog;
    int sleeplogsize;
    sleeplog() {
    	sleeplogsize = 0;
    	sleeplog = new int[30];
    }
    sleeplog(String date, String starttime, String endtime) {
    	this.date = date;
    	this.starttime = starttime;
    	this.endtime = endtime;
    }
    public String getDate() {
    	return this.date;
    }
    public String getStartTime() {
    	return this.starttime;
    }
    public String getEndTime() {
    	return this.endtime;
    }
     public String setDate() {
    	this.date = date;
    }
    public String setStartTime() {
    	this.starttime = starttime;
    }
    public String setEndTime() {
    	this.endtime = endtime;
    }
    public String toString() {

    }
}