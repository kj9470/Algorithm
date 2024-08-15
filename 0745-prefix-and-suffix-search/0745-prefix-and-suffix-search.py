class WordFilter:

    def __init__(self, words: List[str]):
        self.dict = {}
        for index, word in enumerate(words):
            length = len(word)
            for i in range(length + 1):  # pref 길이
                for j in range(length + 1):  # suff 길이
                    prefix = word[:i]
                    suffix = word[-j:] if j != 0 else ''
                    self.dict[(prefix, suffix)] = index

    def f(self, pref: str, suff: str) -> int:
        # 사전에서 (접두어, 접미어) 튜플로 인덱스 조회
        return self.dict.get((pref, suff), -1)