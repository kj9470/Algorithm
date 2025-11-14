n = int(input())
weathers = []

class Weather:
    def __init__(self, date, day, weather):
        self.date = date
        self.day = day
        self.weather = weather

for _ in range(n):
    d, dy, w = input().split()
    weathers.append(Weather(d, dy, w))

sorted_weather = sorted(weathers, key=lambda s: s.date)

for i in range(n):
    w = sorted_weather[i].weather
    if w == 'Rain':
        print(sorted_weather[i].date, sorted_weather[i].day, w)
        break