# HadoopLearn
HadoopLearn


# 主机：47.101.202.85
# 目录：/home/student/huangdongdong/

yarn jar HadoopLearn_hdd-0.0.1.jar /user/student/huangdongdong/input/ /user/student/huangdongdong/phone_data_001

# 执行结果
[student@jikehadoop04 huangdongdong]$ yarn jar HadoopLearn_hdd-0.0.1.jar /user/student/huangdongdong/input/ /user/student/huangdongdong/phone_data_001
WARNING: YARN_OPTS has been replaced by HADOOP_OPTS. Using value of YARN_OPTS.
21/07/14 22:44:28 INFO client.RMProxy: Connecting to ResourceManager at jikehadoop03/172.16.63.15:8032
21/07/14 22:44:29 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
21/07/14 22:44:29 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/student/.staging/job_1625908641529_0151
21/07/14 22:44:29 INFO input.FileInputFormat: Total input files to process : 1
21/07/14 22:44:29 INFO mapreduce.JobSubmitter: number of splits:1
21/07/14 22:44:29 INFO Configuration.deprecation: yarn.resourcemanager.system-metrics-publisher.enabled is deprecated. Instead, use yarn.system-metrics-publisher.enabled
21/07/14 22:44:29 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1625908641529_0151
21/07/14 22:44:29 INFO mapreduce.JobSubmitter: Executing with tokens: []
21/07/14 22:44:29 INFO conf.Configuration: resource-types.xml not found
21/07/14 22:44:29 INFO resource.ResourceUtils: Unable to find 'resource-types.xml'.
21/07/14 22:44:29 INFO impl.YarnClientImpl: Submitted application application_1625908641529_0151
21/07/14 22:44:29 INFO mapreduce.Job: The url to track the job: http://jikehadoop03:8088/proxy/application_1625908641529_0151/
21/07/14 22:44:29 INFO mapreduce.Job: Running job: job_1625908641529_0151
21/07/14 22:44:36 INFO mapreduce.Job: Job job_1625908641529_0151 running in uber mode : false
21/07/14 22:44:36 INFO mapreduce.Job:  map 0% reduce 0%
21/07/14 22:44:40 INFO mapreduce.Job:  map 100% reduce 0%
21/07/14 22:44:45 INFO mapreduce.Job:  map 100% reduce 17%
21/07/14 22:44:46 INFO mapreduce.Job:  map 100% reduce 33%
21/07/14 22:44:47 INFO mapreduce.Job:  map 100% reduce 50%
21/07/14 22:44:48 INFO mapreduce.Job:  map 100% reduce 92%
21/07/14 22:44:49 INFO mapreduce.Job:  map 100% reduce 100%
21/07/14 22:44:49 INFO mapreduce.Job: Job job_1625908641529_0151 completed successfully
21/07/14 22:44:49 INFO mapreduce.Job: Counters: 54
        File System Counters
                FILE: Number of bytes read=857
                FILE: Number of bytes written=2862117
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=2375
                HDFS: Number of bytes written=551
                HDFS: Number of read operations=63
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=24
                HDFS: Number of bytes read erasure-coded=0
        Job Counters 
                Launched map tasks=1
                Launched reduce tasks=12
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=1913
                Total time spent by all reduces in occupied slots (ms)=35142
                Total time spent by all map tasks (ms)=1913
                Total time spent by all reduce tasks (ms)=35142
                Total vcore-milliseconds taken by all map tasks=1913
                Total vcore-milliseconds taken by all reduce tasks=35142
                Total megabyte-milliseconds taken by all map tasks=1958912
                Total megabyte-milliseconds taken by all reduce tasks=35985408
        Map-Reduce Framework
                Map input records=22
                Map output records=22
                Map output bytes=789
                Map output materialized bytes=809
                Input split bytes=146
                Combine input records=0
                Combine output records=0
                Reduce input groups=21
                Reduce shuffle bytes=809
                Reduce input records=22
                Reduce output records=21
                Spilled Records=44
                Shuffled Maps =12
                Failed Shuffles=0
                Merged Map outputs=12
                GC time elapsed (ms)=950
                CPU time spent (ms)=7410
                Physical memory (bytes) snapshot=3238375424
                Virtual memory (bytes) snapshot=33801207808
                Total committed heap usage (bytes)=2991587328
                Peak Map Physical memory (bytes)=519307264
                Peak Map Virtual memory (bytes)=2592215040
                Peak Reduce Physical memory (bytes)=278036480
                Peak Reduce Virtual memory (bytes)=2604470272
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=2229
        File Output Format Counters 
                Bytes Written=551
                
                

