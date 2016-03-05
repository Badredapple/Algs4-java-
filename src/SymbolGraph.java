import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/*
 * API 说明：
 * 基于符号名为定点的API
 * 这里，包括实现函数和一个检验函数
 * 	public class SymbolGraph
 * 				SymbolGraph(String filename, String delim)
 * 			boolean contains(String key)
 * 			int 	index(String key)
 * 			String  name(int v)
 * 			Graph 	G()
 * 
 *  
 *  
 *  
 *  */
public class SymbolGraph 
{
	private ST<String,Integer> st;
	private String[] keys;
	private Graph G;
	
	public SymbolGraph(String stream, String sp)
	{
		st =new ST<String, Integer>();
		In in = new In(stream);
		while(in.hasNextLine())
		{
			String [] a = in.readLine().split(sp);
			
			for(int i=0; i<a.length;i++)
				if(!st.contains(a[i]))
					
					st.put(a[i], st.size());	
		}
		keys = new String[st.size()];
		
		for(String name:st.keys())
			keys[st.get(name)] = name;
				
		G = new Graph(st.size());
		in = new In(stream);
		
		while(in.hasNextLine())
		{
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i = 1; i< a.length;i++)
				G.addEdge(v, st.get(a[i]));	
			
		}	
	}
	
	public boolean contains(String s) 		{	return st.contains(s);	}
	public int index(String s)				{	return st.get(s);		}
	public String name(int v)				{	return keys[v];			}
	
}

