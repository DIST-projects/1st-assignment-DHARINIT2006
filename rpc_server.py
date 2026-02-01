from xmlrpc.server import SimpleXMLRPCServer

server = SimpleXMLRPCServer(("localhost", 9200), allow_none=True)
print("Advanced Text RPC Server started...")

def text_report(text):
    vowels = "aeiouAEIOU"
    consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ"

    report = {}
    report["original_text"] = text
    report["length"] = len(text)
    report["word_count"] = len(text.split())
    report["vowel_count"] = sum(1 for c in text if c in vowels)
    report["consonant_count"] = sum(1 for c in text if c in consonants)
    report["uppercase_count"] = sum(1 for c in text if c.isupper())
    report["lowercase_count"] = sum(1 for c in text if c.islower())
    report["is_palindrome"] = (
        text.replace(" ", "").lower()
        == text.replace(" ", "").lower()[::-1]
    )

    return report

server.register_function(text_report, "text_report")
server.serve_forever()
