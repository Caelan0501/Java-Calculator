package calculator;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class History 
{
	private record Entry(String solution, List<String> subHistory)
	{
		public String toString()
		{
			StringBuilder result = new StringBuilder(solution);
			if (subHistory == null) return result.toString();
			for (String s : subHistory)
			{
				result.append("\n---");
				result.append(s);
			}
			return result.toString();
		}
	}
	
	private final List<Entry> history;
	private boolean paused;

	public History()
	{
	    paused = false;
	    history = new ArrayList<>();
	}

	public void Start() { paused = false; }
	public void Pause() { paused = true; }
	public void Clear() { history.clear(); }

	public void AddEntry(String solution)
	{
	    if (paused) return;
	    history.add(new Entry (solution, null));
	}

	public void AddEntry(String solution, List<String> subHistory)
	{
	    if (paused) return;
	    history.add(new Entry(solution, subHistory));
	}

	/// <summary>
	/// Reads all history from youngest to oldest
	/// </summary>
	/// <returns>"{a} {operator} {b} = {result} \n" {next entry} ...</returns>
	public String ReadAll()
	{
	    StringBuilder result = new StringBuilder();
	    for(Entry entry : history)
	    {
	        result.append("-----------------------\n");
			StringBuilder s = new StringBuilder(entry.toString());
			s.append("\n");
	        result.insert( 0, s);
	        result.append("-----------------------\n");
	    }
	    result.append("End of History");
	    return result.toString();
	}
}
