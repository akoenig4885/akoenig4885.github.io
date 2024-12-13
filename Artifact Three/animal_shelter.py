from pymongo import MongoClient
from bson.objectid import ObjectId
from pprint import pprint


class AnimalShelter(object):
	
	def __init__(self, user = 'aacuser', passw = 'SNHU1234'):
		USER = user
		PASS = passw
		HOST = 'nv-desktop-services.apporto.com'
		PORT = 30379
		DB = 'AAC'
		COL = 'animals'
		
		self.client = MongoClient('mongodb://{}:{}@{}:{:n}'.format(USER,PASS,HOST,PORT))
		self.database = self.client['%s' % (DB)]
		self.collection = self.database['%s' % (COL)]
		
	# Inserts document into database, returning true if insert is successful		
	def create(self, data):
		if data is not None:
			self.database.animals.insert_one(data)
			return True 
		else:
			raise Exception("Nothing to save, because data parameter is empty")
			return False
			
	#Uses the mongoDB find command to read the database and find matches to the passed document. Returns a list of matching documents			
	def read(self, data):
		read_list = []
		if data is not None:
			for animal in self.database.animals.find(data):
				read_list.append(animal)
		#If no document is passed, use the find command with no arguments to return the entire collection		
		else:
			for animal in self.database.animals.find():
				read_list.append(animal)
		return read_list
	
	#Use the mongoDB update_many command to perform the modification on documents that match the query. Returns the number of updated documents
	def update(self, query, modification):
		x = self.database.animals.update_many(query, modification)
		return x.modified_count

	#Use the mongoDB delete command to delete documents that match the query. Returns number of deleted documents
	def delete(self, query):
		x = self.database.animals.delete_many(query)
		return x.deleted_count
