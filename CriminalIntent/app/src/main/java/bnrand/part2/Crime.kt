package bnrand.part2

import java.util.*

data class Crime(val id: UUID = UUID.randomUUID(),
                 var title: String = "",
                 var date: Date = Date(),
                 var isSolved: Boolean = false)
// id, title(제목), date(발생일자), isSolved(해결여부)
/*
 UUID는 안드로이드 프레임워크에 포함된 유틸리티 클래스다 (UUID Universally Unique Identifier)
 이 클래스는 고유한 ID 값을 쉽게 생성하는 방법을 제공한다. 여기서 기본생성자에서 UUID.randomUUID()를 호출해 임의의 UUID 값을 갖는 고유 ID를 생성한다.
 Date 속성은 Date 클래스의 기본 생성자를 호출해 현재 일자로 초기화한다.
 임시 데이터 처리를 위해 데이터 클래스를 다시 설정
 */