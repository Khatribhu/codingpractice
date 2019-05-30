package com.coding.practice.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MeetingScheduler {

    static class Meeting implements Comparable<Meeting> {
        Date startTime;
        Date endTime;
        int duration;

        public static final int MINUTE = 60000;

        //duration in minutes
        Meeting(Date startTime, int duration) {
            this.startTime = startTime;
            this.duration = duration;
            this.endTime = new Date(startTime.getTime() + (MINUTE * duration));

        }

        @Override
        public int compareTo(Meeting o) {
            if (this.endTime.compareTo(o.startTime) < 0) {
                return -1;
            }//end time is before the other's start time
            if (this.startTime.compareTo(o.endTime) > 0) {
                return 1;
            }////start time is after the other's end time
            return 0;
        }

        @Override
        public String toString() {
            return "meeting {" +
                    "from " + startTime +
                    ", minutes=" + duration +
                    '}';
        }
    }

    private List<Meeting> meetings = new ArrayList<Meeting>();

    public Meeting bookRoom(Meeting meeting) {

        if (meetings.isEmpty()) {
            meetings.add(meeting);
            return null;
        } else {
            int pos = -Collections.binarySearch(meetings, meeting);
            if (pos > 0) {
                meetings.add(pos-1, meeting);
                return null;
            } else {
                return meetings.get(-pos);
            }
        }
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public static void main(String[] args) {
        MeetingScheduler meetingScheduler = new MeetingScheduler();

        Meeting[] meetingsToBook = new Meeting[]{
                //October 3rd 2014
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 15, 00), 15),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 16, 00), 15),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 17, 00), 60),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 18, 00), 15),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 14, 50), 10),
                new Meeting(new Date(2014 - 1900, 10 - 1, 3, 14, 55), 10)
        };

        for (Meeting m : meetingsToBook) {
            Meeting oldMeeting = meetingScheduler.bookRoom(m);
            if (oldMeeting != null) {
                System.out.println("Could not book room for " + m + " because it collides with " + oldMeeting);
            }
        }

        System.out.println("meetings booked: " + meetingScheduler.getMeetings().size());

        for (Meeting m : meetingScheduler.getMeetings()) {
            System.out.println(m.startTime + "-> " + m.duration + " mins");
        }

    }
}