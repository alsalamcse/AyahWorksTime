package com.ayahkh.ayahworkstime;



public class Worker
{

    private String timein;
    private String timeout;
    private String date;
    private long _id;

    public Worker()
    {

    }

    public Worker(String timein, String timeout, String date, long _id) {
        this.timein = timein;
        this.timeout = timeout;
        this.date = date;
        this._id = _id;
    }

    public String getTimein() {
        return timein;
    }

    public long get_id() {
        return _id;
    }

    public void setTimein(String timein) {
        this.timein = timein;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTimeout() {
        return timeout;
    }

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "timein=" + timein +
                ", timeout=" + timeout +
                ", date='" + date + '\'' +
                '}';
    }

}
