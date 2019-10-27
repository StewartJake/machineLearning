def build_name_question(position)
    return 'What is your ' + position + ' name?'
end

puts build_name_question('first')
first_name = gets.chomp
puts build_name_question('middle')
middle_name = gets.chomp
puts build_name_question('last')
last_name = gets.chomp
length = first_name.length + middle_name.length + last_name.length
puts 'You name is ' + length.to_s + ' letters long.'
