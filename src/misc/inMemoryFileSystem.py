
# Enter your code here. Read input from STDIN. Print output to STDOUT
# Hi Neil
# if path is invalid, then we throw an error for write, read to do the same
"""
Solution - 

1. directory set - has all the directories - if this redundant?
2. file map - filepath to contents

to make it efficient/eliminate the set - have a custom object as a key/ it has field for it being directory or file
"""
#from typing import str
print('hello')

directory_set = set()
directory_set.add("/")

file_map = {}

#throw an error if parent doesn't exist
def mkdir(path: str):
    parent = _get_parent(path)
    if parent == "":
        directory_set.add(path)
        return
    else:
        if parent in directory_set:
            directory_set.add(path)
            return
        else:
            raise ValueError("Parent directory not found")
        
def write_file(path: str, data: str):
    parent = _get_parent(path)
    if parent == "":
        file_map[path] = data
    else:
        if parent in directory_set:
            file_map[path] = data
            return
        else:
            raise ValueError("Parent directory not found")
        
def read_file(path: str) -> str:
    if path in file_map:
        return file_map[path]
    else:
        raise ValueError("Parent directory not found")
    
        
def _get_parent(path: str) -> str:
    
    if path == "/":
      return ""
    
    dirs = path.split("/")

    if len(dirs) == 0:
        raise ValueError("Invalid path")
    elif len(dirs) == 1:
        return ""
    else:
        # remove first token which is always empty
        parent_dirs = dirs[1:-1]
        output = ""
        for token in parent_dirs:
            output = output + "/" + token
        return output
    
        
sample_path = "/abc/xyz/def"
print(_get_parent(sample_path))


sample_path = "/"
print("parent of empty path = ")
print(_get_parent(sample_path)) 
               
                  
mkdir("/abc")    
write_file("/abc/a.txt", "this is a sample string") 
print(read_file("/abc/a.txt")) 

"""
#expected to fail
mkdir("/xyz/abc")
#expected to fail
write_file("/xyz/a.txt", "this is a sample string")
"""

#expected to fail
read_file("b.txt") 
        
            
            
