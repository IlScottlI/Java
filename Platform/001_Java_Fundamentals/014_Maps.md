<table width="100%">
    <tr>
        <td><a href="./013_Loops.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./015_Exceptions.md">Next</a></td>
    </tr>
</table>

#

#   Maps
### __Objectives:__
*   Introduction to HashMap
*   Insert key and values pairs in a HashMap
*   Retrieve information from a HashMap
*   Loop through a HashMap

#

While arrays and lists are useful, not everything is stored in a specific sequential order. There are many things in our lives that we keep track of where we use key-value pairs. There are countless examples: you map names to faces, places to experiences, and so on.

In code, there are also countless use cases where you will want to use a key-value pair: IDs to database entries, emails to users, URLs to view pages, and so on. Every single developer will need to use a key-value map at one point.

On the Java platform, sets of key-value pairs are stored in what we call "Maps." The "Map" type is implemented in a few different ways, the primary of which are `HashMap`s.

HashMap
One of the most commonly used map implementations in the Java platform are `HashMap`s. These allow you to store sets of key value pairs, but does not have any order, even if you iterate over it! However, if you wanted to have order, you could use another implementation, but the most common Map to use is `HashMap` since we are usually unconcerned with the order when using a map.

### __Usage:__
To use a `HashMap` we first need to create one:
```java
import java.util.HashMap;
HashMap<String, String> userMap = new HashMap<String, String>();
```
Once you've created it you can put your key-value pairs into it:

userMap.put("nninja@codingdojo.com", "Nancy Ninja");
userMap.put("ssamurai@codingdojo.com", "Sam Samurai");
And get them out:
```
String name = userMap.get("nninja@codingdojo.com");
```
### __Iterating over a HashMap__
There are a few ways to iterate over a `HashMap`. Here, we are going to show you the 2 most common ways to loop over a `HashMap`

### __HashMapFun.java__
```java
import java.util.Set;
public class HashMapFun {
    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("nninja@codingdojo.com", "Nancy Ninja");
        userMap.put("ssamurai@codingdojo.com", "Sam Samurai");
        userMap.put("wwizard@codingdojo.com", "Walter Wizard");
        // get the keys by using the keySet method
        Set<String> keys = userMap.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(userMap.get(key));    
        }
    }
}
```
To iterate over a `HashMap`, we introduced a new type called `Set`. In java, a `Set` is what we call an `interface`. We will be introducing `interface`s in the Java OOP section, but for now, just think of an `interface` as any other type. By definition, a `Set` is a collection that contains no duplicates, which is perfect for a `HashMap`. Therefore, the keySet method returns a set of all the keys in our map. Then, in our for-loop, we iterate over the set, print the keys, and get the value in our map with said key.

You can do a quite a bit more with `HashMap`s. Some of the most common used methods are: `clear`, `containsKey`, `containsValue`,`isEmpty`, `keySet`, `remove`, `replace`, `size`, `values`. Try these out to see what you can do with `HashMap`s.

### __Useful Links:__
*   [Hash Map](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
*   [Map Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html)

# Map of the Hashmatique
A band from Teignmouth, Devon has contracted your company to organize their song list. Part of this is that they don't want to use song numbers in storing the lyrics until they are certain of the order. They insist that you be able to immediately retrieve the lyrics based on the song name, and your PM has asked you to implement this.

To demonstrate to the band how it would work, use a HashMap with the track titles as keys and some sample lyrics as the values. Add at least 4 songs to your trackList HashMap and then pull one out by its name. They also want to be able to see all the tracks with the lyrics immediately following them.

### __Objectives:__
*   Create your first HashMap.
*   Iterate over a HashMap.
### __Tasks:__
*   Create a trackList of type HashMap
*   Add in at least 4 songs that are stored by title
*   Pull out one of the songs by its track title
*   Print out all the track names and lyrics in the format Track: Lyrics


#

[]()
<table width="100%">
    <tr>
        <td><a href="./013_Loops.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./015_Exceptions.md">Next</a></td>
    </tr>
</table>
