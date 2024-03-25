<div align="center">
  <h1 align="center">Deep Signal</h1> 
  <h3>An Open-Source Framework for Real-Time Multimedia Processing on Apache Spark</h3>
  <kbd>
  <img src="/posts/deep-signal/images/deep-signal.png" width="256px"> 
  </br>
  </kbd>
</div>


# Unveiling Deep Signal: Part 1 — Defining the Problem

## Abstract
In the current AI era, the significance of data analysis frameworks and platforms has heightened, as they serve as the backbone for leveraging data in artificial intelligence (AI) applications. These frameworks and platforms facilitate the processing, interpretation, and utilization of vast amounts of data, enabling AI algorithms to learn, adapt, and make informed decisions.

Today, Data Analysis Frameworks excel in providing developers with tools for processing and analyzing structured and semi-structured data at scale. However, their capabilities in handling unstructured data are somewhat limited. In this series of articles, I will discuss Deep Signal, a framework designed to enhance Apache Spark’s capabilities for processing audio and video data.

## Problem Statement
AI depends on high-quality data, which needs to be plentiful and in a format suitable for processing and transfer. Structured and semi-structured data are advantageous because they are easy to analyze and transfer, especially with modern data analysis frameworks. Here’s a simple example illustrating how Apache Spark can effectively read, clean, and analyze structured data at a large scale.

```scala

val df = spark.read
      .option("header", "true")
      .csv(s3Path)

// Clean, normalize data, and analyze
df.columns.foldLeft(df) { (accDF, colName) =>
  accDF.withColumn(colName, trim(col(colName)))
}.groupBy("columnName").count()

```

Even when dealing with unstructured data, such as text, Apache Spark can perform quite effectively. Let’s consider the task of constructing an inverted index for extensive collections of text files as an example. With Apache Spark, accomplishing this task is straightforward with just a simple piece of code.

```scala
val textRDD = spark.sparkContext.textFile("s3://your-bucket-name/path/to/files/*")

// Tokenize the text and flatMap to (word, doc_id) pairs
val invertedIndex = textRDD
  .flatMap(line => {
    val words = line.split(" ")
    words.distinct.map(word => (word, line.hashCode.toString))
  })
  .filter(_._1.nonEmpty) // Filter out empty strings
  .groupByKey() // Group by word
  .mapValues(_.toList.sorted) // Sort and convert to list

// Save the inverted index to a file in S3
invertedIndex.saveAsTextFile("s3://your-bucket-name/path/to/output/inverted_index")

```

Let’s make things a bit more complex. Now, imagine we have tons of video or audio files full of useful information. We want to create an inverted index that helps us find specific words or phrases in these files. It should also tell us where these words or phrases are mentioned in each video or audio. Can we use Apache Spark to do this as easily as we do with text or structured data? The obvious answer is yes, we can set up a process where we turn video and audio into text first and then use the code from the example above. But here’s the thing: wouldn’t it be better to have this process built directly into the Data Analytics Platform? Let’s think of a concept called MediaRDD. MediaRDD is a distributed dataset of video, audio, or images content that implements all known data extraction methods from video, audio and images content

```scala
// Load media files - mp3, mp4, wav, flac etc
val mediaRDD: MediaRDD = spark.sparkContext.mediaFile(
  "s3://your-bucket-name/path/to/files/*")

// Tokenize the text and flatMap to (word, doc_id) pairs
val invertedIndex = mediaRDD
  .transcribe()
  .flatMap(line => {
    val words = line.split(" ")
    words.distinct.map(word => (word, line.hashCode.toString))
  })
  .filter(_._1.nonEmpty) // Filter out empty strings
  .groupByKey() // Group by word
  .mapValues(_.toList.sorted) // Sort and convert to list

// Save the inverted index to a file in S3
invertedIndex.saveAsTextFile("s3://your-bucket-name/path/to/output/inverted_index")
```

Analyzing unstructured data is vital, especially given the substantial amount of video and audio data that businesses accumulate from platforms like Zoom, Google Meet, MS Teams, and others. Just envision the possibilities if we could effortlessly analyze all forms of unstructured data and extract valuable insights. This capability would enable us to utilize various data types, including audio, video, images, spatial data, and more, to develop strong AI systems.

## Objectives
Let’s explore the signals extracted from unstructured data, applicable across domains like marketing, customer service, healthcare, finance, and beyond. These insights enable data-driven decisions and the development of AI systems for process automation. Starting with the most apparent signals:

- Speech recognition: Converting spoken words from audio data into text format, enabling transcription of meetings, customer service calls, or interviews.
- Sentiment Analysis: Analyzing tone of voice and language patterns to infer emotions, attitudes, or opinions expressed in conversations.
- Object detection: Detecting and identifying objects, people, or scenes in images or video frames, enabling applications in security surveillance, autonomous vehicles, or image-based search.
- Emotion recognition: Analyzing facial expressions, tone of voice, or language patterns in audio and video data to infer emotional states, useful in human-computer interaction, customer experience analysis, or mental health monitoring.
- Activity Recognition: Detecting and classifying human actions or movements depicted in videos, facilitating applications in sports analytics, healthcare monitoring, or security surveillance.
- Text Recognition: Extracting text from images, including printed text in documents, signs, or labels, facilitating applications in document processing, optical character recognition (OCR), or image-based search.

In essence, Deep Signal’s main goal is to enhance Apache Spark by enabling seamless extraction of signals from images, video, and audio, thus enabling scalable analysis.

## What’s next
In the upcoming article, I’ll delve into the design and implementation of MediaRDD and Speech Recognition features. Stay tuned for more insights!