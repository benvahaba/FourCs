package model;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

public class ImageFoldierListener implements Runnable
{
	private final String PATH;
	
	public ImageFoldierListener(String i_Path)
	{
		PATH = i_Path;
		
	}

	@Override
	public void run() {
		try(WatchService service = FileSystems.getDefault().newWatchService())
		{
			Map<WatchKey, Path> keyMap = new HashMap<>();
			Path path = Paths.get(PATH);
			keyMap.put(path.register(service, 
					StandardWatchEventKinds.ENTRY_CREATE), path);
			
			WatchKey watchKey;
			
			do {
				watchKey = service.take();
				Path eventDir = keyMap.get(watchKey);
				
				for(WatchEvent<?> event : watchKey.pollEvents())
				{
					
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path)event.context();
					System.out.println(eventDir+": "+ kind+": "+eventPath);
				}
				
				
				
			} while (watchKey.reset());
			
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
