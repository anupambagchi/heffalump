CLASSNAME=com.hadooptraining.summarize.WordCountWithTools

echo Deleting old output directory...
hadoop fs -rm -r /user/shrek/output
echo Running Hadoop task...
hadoop jar $DEV_HOME/target/heffalump-1.0.jar $CLASSNAME input output
echo Here is the output...
hadoop fs -cat /user/shrek/output/part-r-00000
