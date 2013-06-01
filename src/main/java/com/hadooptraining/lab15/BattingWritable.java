package com.hadooptraining.lab15;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class BattingWritable implements Writable {

    private Text playerID, year;
    private IntWritable runs;

    public BattingWritable() {
        this.playerID = new Text();
        this.year =  new Text();
        this.runs = new IntWritable();
    }

    public void set (String playerID, String year, int runsAllowed) {
        this.playerID.set(playerID);
        this.year.set(year);
        this.runs.set(runsAllowed);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        playerID.readFields(in);
        year.readFields(in);
        runs.readFields(in);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        playerID.write(out);
        year.write(out);
        runs.write(out);
    }

    public int hashCode() {
        return playerID.hashCode();
    }

    public Text getPlayerID() {
        return playerID;
    }

    public Text getYear() {
        return year;
    }

    public IntWritable getRuns() {
        return runs;
    }

}

/*
          Batting TABLE
          =============
1         playerID       Player ID code
2         yearID         Year
3         stint          player's stint (order of appearances within a season)
4         teamID         Team
5         lgID           League
6         G              Games
7         G_batting      Game as batter
8         AB             At Bats
9         R              Runs
10        H              Hits
11        2B             Doubles
12        3B             Triples
13        HR             Homeruns
14        RBI            Runs Batted In
15        SB             Stolen Bases
16        CS             Caught Stealing
17        BB             Base on Balls
18        SO             Strikeouts
19        IBB            Intentional walks
20        HBP            Hit by pitch
21        SH             Sacrifice hits
22        SF             Sacrifice flies
23        GIDP           Grounded into double plays
24        G_Old          Old version of games (deprecated)

*/