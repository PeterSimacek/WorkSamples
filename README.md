# Work Samples for application as Junior Java Developer

This repository contains a Code Example intended to support my application as a Junior Java Developer.
Since the development of tools and features for graph databases ist part of the job activities, I decided to implement
my own simple version of a graph database.

It uses a generic class "Graph", which implements a weighted graph. The nodes and the edge properties  of the graph can 
be of arbitrary datatypes.

Another class "LabeledPropertyNodes" allows for the creation of nodes with a name, a label and a collection of properties.

In the main-Method, an instance of the class Graph is created with the datatype LabeledPropertyNode as nodes and the datatype 
String as edge properties. 
The resulting graph is a labeled property graph - one of the concepts for the realisation of a graph database.
The example continues with the creation of nodes which represent movies, actors and directors. The nodes get connected by edges.
Finally some of the implemented methods are used to print the graph and to find movie recommendations for a person 
with specific preferences.
