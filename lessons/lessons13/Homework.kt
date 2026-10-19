

from types import MappingProxyType


# 1. Среднее время выполнения теста
def task_01_avg_time(times: dict) -> float:
return sum(times.values()) / len(times)


# 2. Список всех тестовых методов
def task_02_list_methods(meta: dict) -> list:
return list(meta.keys())


# 3. Добавить новый тест в изменяемый словарь
def task_03_add_test(results: dict, name: str, status: str) -> dict:
results.update({name: status})
return results


# 4. Количество успешных тестов
def task_04_count_passed(results: dict) -> int:
return sum(1 for v in results.values() if v == "passed")


# 5. Удалить исправленные баги
def task_05_remove_fixed(bugs: dict) -> dict:
for k in [k for k, v in bugs.items() if v == "fixed"]:
del bugs[k]
return bugs


# 6. Сообщение о странице и статусе
def task_06_pages_report(pages: dict) -> list:
return [f"Страница {url}: статус {status}" for url, status in pages.items()]


# 7. Сервисы с временем ответа выше порога
def task_07_slow_services(services: dict, threshold: float) -> dict:
return {k: v for k, v in services.items() if v > threshold}


# 8. Статус endpoint или «не протестирован»
def task_08_endpoint_status(api: dict, endpoint: str) -> str:
return api.get(endpoint, "не был протестирован")


# 9. Значение browserType (не может быть null)
def task_09_browser_type(config: dict) -> str:
return config["browserType"]


# 10. Копия неизменяемого словаря + новая версия
def task_10_add_version(versions: MappingProxyType, new_key: str, new_val: str) -> MappingProxyType:
return MappingProxyType({**versions, new_key: new_val})


# 11. Настройки для модели или по умолчанию
def task_11_device_settings(devices: dict, model: str) -> str:
return devices.get(model, "default_settings")


# 12. Проверка наличия кода ошибки
def task_12_has_error_code(errors: dict, code: int) -> bool:
return code in errors


# 13. Фильтр сценариев по версии в ключе
def task_13_filter_by_version(scenarios: dict, version: str) -> dict:
return dict(filter(lambda kv: version in kv[0], scenarios.items()))


# 14. Есть ли модули с неудачным тестированием
def task_14_has_failed(modules: dict) -> bool:
return any(v == "failed" for v in modules.values())


# 15. Добавить настройки из другого словаря
def task_15_merge_env(env: dict, extra: dict) -> dict:
env |= extra
return env


# 16. Объединить два неизменяемых словаря
def task_16_merge_bugs(b1: MappingProxyType, b2: MappingProxyType) -> MappingProxyType:
return MappingProxyType({**b1, **b2})


# 17. Очистить изменяемый словарь
def task_17_clear(last_run: dict) -> dict:
last_run.clear()
return last_run


# 18. Исключить skipped из отчёта
def task_18_exclude_skipped(report: dict) -> dict:
return {k: v for k, v in report.items() if v != "skipped"}


# 19. Копия словаря без нескольких конфигураций
def task_19_drop_configs(configs: dict, to_remove: set) -> dict:
return {k: v for k, v in configs.items() if k not in to_remove}


# 20. Отчёт в виде списка строк
def task_20_report_lines(results: dict) -> list:
return list(map(lambda kv: f"Test ID: {kv[0]} — {kv[1]}", results.items()))


# 21. Изменяемый → неизменяемый (архивация)
def task_21_archive(mutable: dict) -> MappingProxyType:
return MappingProxyType(dict(mutable))


# 22. Заменить числовые ID на строковые
def task_22_str_ids(data: dict) -> dict:
return dict(map(lambda kv: (str(kv[0]), kv[1]), data.items()))


# 23. Увеличить оценки на 10%
def task_23_boost_perf(perf: dict) -> dict:
return {k: round(v * 1.1, 2) for k, v in perf.items()}


# 24. Проверка, пуст ли словарь ошибок компиляции
def task_24_compile_errors_empty(compile_errors: dict) -> bool:
return len(compile_errors) == 0


# 25. Убедиться, что словарь нагрузочного тестирования не пуст
def task_25_load_not_empty(load_results: dict) -> bool:
return bool(load_results)


# 26. Все ли автотесты прошли успешно
def task_26_all_passed(results: dict) -> bool:
return all(v == "passed" for v in results.values())


# 27. Есть ли хотя бы один тест с ошибкой
def task_27_any_failed(results: dict) -> bool:
return any(v == "failed" for v in results.values())


# 28. Оставить неуспешные тесты с «optional» в названии
def task_28_optional_failed(services: dict) -> dict:
return {k: v for k, v in services.items() if v != "passed" and "optional" in k}


# ============================ ДЕМОНСТРАЦИЯ ============================
if __name__ == "__main__":
print("1.", task_01_avg_time({"test_login": 1.2, "test_pay": 2.8, "test_cart": 1.5}))
print("2.", task_02_list_methods({"test_a": "owner=ivan", "test_b": "owner=olga"}))
print("3.", task_03_add_test({"test_a": "passed"}, "test_b", "failed"))
print("4.", task_04_count_passed({"t1": "passed", "t2": "failed", "t3": "passed"}))
print("5.", task_05_remove_fixed({"BUG-1": "fixed", "BUG-2": "open"}))
print("6.", task_06_pages_report({"https://a.ru": 200, "https://b.ru": 404}))
print("7.", task_07_slow_services({"auth": 0.3, "pay": 1.5, "search": 0.8}, 0.5))
print("8.", task_08_endpoint_status({"GET /users": "200"}, "GET /orders"))
print("9.", task_09_browser_type({"browserType": "chrome", "headless": "true"}))
print("10.", dict(task_10_add_version(MappingProxyType({"v1.0": "stable"}), "v1.1", "beta")))
print("11.", task_11_device_settings({"iPhone 13": "iOS 17"}, "Galaxy S23"))
print("12.", task_12_has_error_code({404: "Not Found", 500: "Server Error"}, 404))
print("13.", task_13_filter_by_version({"T1_v2.0": "Passed", "T2_v1.5": "Failed", "T3_v2.0": "Skipped"}, "v2.0"))
print("14.", task_14_has_failed({"auth": "passed", "cart": "failed"}))
print("15.", task_15_merge_env({"browser": "chrome"}, {"timeout": "30s", "headless": "true"}))
print("16.", dict(task_16_merge_bugs(MappingProxyType({"BUG-1": "open"}), MappingProxyType({"BUG-2": "fixed"}))))
print("17.", task_17_clear({"t1": "passed", "t2": "failed"}))
print("18.", task_18_exclude_skipped({"t1": "passed", "t2": "skipped", "t3": "failed"}))
print("19.", task_19_drop_configs({"a": 1, "b": 2, "c": 3, "d": 4}, {"b", "d"}))
print("20.", task_20_report_lines({"T1": "passed", "T2": "failed"}))
print("21.", task_21_archive({"t1": "passed", "t2": "failed"}))
print("22.", task_22_str_ids({101: 1.2, 102: 2.5}))
print("23.", task_23_boost_perf({"1.0": 100.0, "2.0": 120.5}))
print("24.", task_24_compile_errors_empty({}))
print("25.", task_25_load_not_empty({"rps": 1000}))
print("26.", task_26_all_passed({"t1": "passed", "t2": "passed"}))
print("27.", task_27_any_failed({"t1": "passed", "t2": "failed"}))
print("28.", task_28_optional_failed({"login_optional": "failed", "pay": "failed", "cart_optional": "passed"}))