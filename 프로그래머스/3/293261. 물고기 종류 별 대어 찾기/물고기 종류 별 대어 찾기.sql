select i.id, n.fish_name, i.length
from fish_info i join fish_name_info n
on i.fish_type = n.fish_type
where (i.fish_type, i.length) in (select i.fish_type, max(i.length)
                                        from fish_info i
                                        group by i.fish_type);