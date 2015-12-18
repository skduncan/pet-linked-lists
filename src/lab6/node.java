package lab6;

public class node<T> 
{
	    public T data; 
	    public node<T> link;

	    //default constructor 
	    public node()
		{
		    this.data = null;
		    this.link = null;
		}//end of constructor

	    public node(T theData)
		{
		    this.data = theData;
		    this.link = null;
		}

	    public node(node<T> theLink)
		{
		    this.data = null;
		    this.link = theLink;
		}

	    public node(T theData, node<T> theLink)
		{
		    this.data = theData;
		    this.link = theLink;
		}

	}//End of Node<T> public class. 

