import com.intellij.database.model.DasTable
import com.intellij.database.model.ObjectKind
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil

import java.text.DateFormat
import java.text.SimpleDateFormat

/*
 * Available context bindings:
 *   SELECTION   Iterable<DasObject>
 *   PROJECT     project
 *   FILES       files helper
 */
packageName = "com.muyuan.zhcl.auth.mapper;"  //这里要换成自己项目 实体的包路径
typeMapping = [
        (~/(?i)int/)                      : "Integer",  //数据库类型和Jave类型映射关系
        (~/(?i)float|double|real/): "Double",
        (~/(?i)decimal/): "Money",
        (~/(?i)bool|boolean/)             : "Boolean",
        (~/(?i)datetime|timestamp/)       : "LocalDateTime",
        (~/(?i)date/)                     : "LocalDate",
        (~/(?i)/)                         : "String"
]

FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir ->
    SELECTION.filter { it instanceof DasTable && it.getKind() == ObjectKind.TABLE }.each { generate(it, dir) }
}

def generate(table, dir) {
    // ====================================== 文件名称
    def className = javaName(table.getName().drop(1), true)
    def fields = calcFields(table)
    new File(dir, className + "Mapper" + ".xml").withPrintWriter("utf-8") { out -> generate(out, table, className, fields) }
}

def generate(out, table, className, fields) {
    // ====================================== 表名称
    def tableName = table.getName()
    // ====================================== className
    def cName = className - "T" + "Mapper"
    def doName = className - "T" + "DO"
    out.println "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
    out.println "<!DOCTYPE mapper\n" +
            "        PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n" +
            "        \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">"
    out.println "<mapper namespace=\"com.muyuan.zhcl.auth.mapper." + cName + "\">"
    out.println ""
    out.println "</mapper>"

}

def calcFields(table) {
    DasUtil.getColumns(table).reduce([]) { fields, col ->
        def spec = Case.LOWER.apply(col.getDataType().getSpecification())
        def typeStr = typeMapping.find { p, t -> p.matcher(spec).find() }.value
        fields += [[
                           name   : javaName(col.getName(), false),
                           colum  : col.getName(),
                           type   : typeStr,
                           comment: col.getComment(),
                           annos  : ""]]
    }
}

def javaName(str, capitalize) {
    def s = str.split(/(?<=[^\p{IsLetter}])/).collect { Case.LOWER.apply(it).capitalize() }
            .join("").replaceAll(/[^\p{javaJavaIdentifierPart}]/, "_").replaceAll(/_/, "")
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}