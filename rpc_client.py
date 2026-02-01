import xmlrpc.client

proxy = xmlrpc.client.ServerProxy("http://localhost:9200/")

text = "Never Odd Or Even"
result = proxy.text_report(text)

print("========= TEXT ANALYSIS REPORT =========")
print("Original Text       :", result["original_text"])
print("Total Length        :", result["length"])
print("Word Count          :", result["word_count"])
print("Vowel Count         :", result["vowel_count"])
print("Consonant Count     :", result["consonant_count"])
print("Uppercase Letters   :", result["uppercase_count"])
print("Lowercase Letters   :", result["lowercase_count"])

print("---------------------------------------")
if result["is_palindrome"]:
    print("Palindrome Check    : YES, it is a palindrome")
else:
    print("Palindrome Check    : NO, it is not a palindrome")

print("========= END OF REPORT =========")
